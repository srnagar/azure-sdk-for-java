param baseName string
param location string = resourceGroup().location
param urlSuffix string = environment().suffixes.storage

var primaryAccountName = baseName
//var pageBlobStorageAccountName = '${baseName}pageblob'

resource primaryAccount 'Microsoft.Storage/storageAccounts@2022-09-01' = {
  name: primaryAccountName
  location: location
  sku: {
    name: 'Premium_LRS'
  }
  kind: 'BlockBlobStorage'
  properties: {}
}

var sasToken = primaryAccount.listAccountSas('2023-05-01', {
  signedServices: 'b'
  signedResourceTypes: 'sco'
  signedPermission: 'rwdlacup'
  signedExpiry: '2025-12-31T23:59:59Z'
}).accountSasToken

/*resource pageBlobStorageAccount 'Microsoft.Storage/storageAccounts@2022-09-01' = {
  name: pageBlobStorageAccountName
  location: location
  sku: {
    name: 'Premium_LRS'
  }
  kind: 'StorageV2'
  properties: {}
}*/

output STORAGE_ENDPOINT_STRING string = '"https://${primaryAccountName}.blob.${urlSuffix}/?${sasToken}"'
//output PAGE_BLOB_STORAGE_ENDPOINT_STRING string = '"https://${pageBlobStorageAccountName}.blob.core.windows.net/${sasToken}"'
