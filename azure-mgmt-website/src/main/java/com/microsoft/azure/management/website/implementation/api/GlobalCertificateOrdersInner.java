/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.website.implementation.api;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceResponseBuilder;
import com.microsoft.azure.CloudException;
import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.ServiceResponseCallback;
import com.microsoft.rest.Validator;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.Response;

/**
 * An instance of this class provides access to all the operations defined
 * in GlobalCertificateOrders.
 */
public final class GlobalCertificateOrdersInner {
    /** The Retrofit service to perform REST calls. */
    private GlobalCertificateOrdersService service;
    /** The service client containing this operation class. */
    private WebSiteManagementClientImpl client;

    /**
     * Initializes an instance of GlobalCertificateOrdersInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public GlobalCertificateOrdersInner(Retrofit retrofit, WebSiteManagementClientImpl client) {
        this.service = retrofit.create(GlobalCertificateOrdersService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for GlobalCertificateOrders to be
     * used by Retrofit to perform actually REST calls.
     */
    interface GlobalCertificateOrdersService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("subscriptions/{subscriptionId}/providers/Microsoft.CertificateRegistration/certificateOrders")
        Call<ResponseBody> getAllCertificateOrders(@Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage);

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("subscriptions/{subscriptionId}/providers/Microsoft.CertificateRegistration/validateCertificateRegistrationInformation")
        Call<ResponseBody> validateCertificatePurchaseInformation(@Path("subscriptionId") String subscriptionId, @Body CertificateOrderInner certificateOrder, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage);

    }

    /**
     * Lists all domains in a subscription.
     *
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the CertificateOrderCollectionInner object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<CertificateOrderCollectionInner> getAllCertificateOrders() throws CloudException, IOException, IllegalArgumentException {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        Call<ResponseBody> call = service.getAllCertificateOrders(this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage());
        return getAllCertificateOrdersDelegate(call.execute());
    }

    /**
     * Lists all domains in a subscription.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getAllCertificateOrdersAsync(final ServiceCallback<CertificateOrderCollectionInner> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (this.client.subscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null."));
            return null;
        }
        if (this.client.apiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null."));
            return null;
        }
        Call<ResponseBody> call = service.getAllCertificateOrders(this.client.subscriptionId(), this.client.apiVersion(), this.client.acceptLanguage());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<CertificateOrderCollectionInner>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getAllCertificateOrdersDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<CertificateOrderCollectionInner> getAllCertificateOrdersDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<CertificateOrderCollectionInner, CloudException>(this.client.restClient().mapperAdapter())
                .register(200, new TypeToken<CertificateOrderCollectionInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Validate certificate purchase information.
     *
     * @param certificateOrder Certificate order
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the Object object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<Object> validateCertificatePurchaseInformation(CertificateOrderInner certificateOrder) throws CloudException, IOException, IllegalArgumentException {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (certificateOrder == null) {
            throw new IllegalArgumentException("Parameter certificateOrder is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        Validator.validate(certificateOrder);
        Call<ResponseBody> call = service.validateCertificatePurchaseInformation(this.client.subscriptionId(), certificateOrder, this.client.apiVersion(), this.client.acceptLanguage());
        return validateCertificatePurchaseInformationDelegate(call.execute());
    }

    /**
     * Validate certificate purchase information.
     *
     * @param certificateOrder Certificate order
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall validateCertificatePurchaseInformationAsync(CertificateOrderInner certificateOrder, final ServiceCallback<Object> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (this.client.subscriptionId() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null."));
            return null;
        }
        if (certificateOrder == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter certificateOrder is required and cannot be null."));
            return null;
        }
        if (this.client.apiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(certificateOrder, serviceCallback);
        Call<ResponseBody> call = service.validateCertificatePurchaseInformation(this.client.subscriptionId(), certificateOrder, this.client.apiVersion(), this.client.acceptLanguage());
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Object>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(validateCertificatePurchaseInformationDelegate(response));
                } catch (CloudException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<Object> validateCertificatePurchaseInformationDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<Object, CloudException>(this.client.restClient().mapperAdapter())
                .register(200, new TypeToken<Object>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
