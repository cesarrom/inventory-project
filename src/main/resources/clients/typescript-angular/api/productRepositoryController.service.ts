/**
 * Inventory Management System
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 2.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
/* tslint:disable:no-unused-variable member-ordering */

import { Inject, Injectable, Optional }                      from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams,
         HttpResponse, HttpEvent }                           from '@angular/common/http';
import { CustomHttpUrlEncodingCodec }                        from '../encoder';

import { Observable }                                        from 'rxjs/Observable';

import { ProductRepositoryDto } from '../model/productRepositoryDto';
import { ResponseCanonicalListProductRepositoryDto } from '../model/responseCanonicalListProductRepositoryDto';
import { ResponseCanonicalProductRepositoryDto } from '../model/responseCanonicalProductRepositoryDto';

import { BASE_PATH, COLLECTION_FORMATS }                     from '../variables';
import { Configuration }                                     from '../configuration';


@Injectable()
export class ProductRepositoryControllerService {

    protected basePath = 'https://localhost:9091';
    public defaultHeaders = new HttpHeaders();
    public configuration = new Configuration();

    constructor(protected httpClient: HttpClient, @Optional()@Inject(BASE_PATH) basePath: string, @Optional() configuration: Configuration) {
        if (basePath) {
            this.basePath = basePath;
        }
        if (configuration) {
            this.configuration = configuration;
            this.basePath = basePath || configuration.basePath || this.basePath;
        }
    }

    /**
     * @param consumes string[] mime-types
     * @return true: consumes contains 'multipart/form-data', false: otherwise
     */
    private canConsumeForm(consumes: string[]): boolean {
        const form = 'multipart/form-data';
        for (const consume of consumes) {
            if (form === consume) {
                return true;
            }
        }
        return false;
    }


    /**
     * createProductRepository
     * 
     * @param entityParam entityParam
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public createProductRepositoryUsingPOST(entityParam: ProductRepositoryDto, observe?: 'body', reportProgress?: boolean): Observable<ResponseCanonicalProductRepositoryDto>;
    public createProductRepositoryUsingPOST(entityParam: ProductRepositoryDto, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<ResponseCanonicalProductRepositoryDto>>;
    public createProductRepositoryUsingPOST(entityParam: ProductRepositoryDto, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<ResponseCanonicalProductRepositoryDto>>;
    public createProductRepositoryUsingPOST(entityParam: ProductRepositoryDto, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (entityParam === null || entityParam === undefined) {
            throw new Error('Required parameter entityParam was null or undefined when calling createProductRepositoryUsingPOST.');
        }

        let headers = this.defaultHeaders;

        // to determine the Accept header
        let httpHeaderAccepts: string[] = [
            '*/*'
        ];
        const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        if (httpHeaderAcceptSelected != undefined) {
            headers = headers.set('Accept', httpHeaderAcceptSelected);
        }

        // to determine the Content-Type header
        const consumes: string[] = [
            'application/json'
        ];
        const httpContentTypeSelected: string | undefined = this.configuration.selectHeaderContentType(consumes);
        if (httpContentTypeSelected != undefined) {
            headers = headers.set('Content-Type', httpContentTypeSelected);
        }

        return this.httpClient.post<ResponseCanonicalProductRepositoryDto>(`${this.basePath}/product-repositories/`,
            entityParam,
            {
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

    /**
     * findProductRepository
     * 
     * @param id id
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public findProductRepositoryUsingGET(id: number, observe?: 'body', reportProgress?: boolean): Observable<ResponseCanonicalProductRepositoryDto>;
    public findProductRepositoryUsingGET(id: number, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<ResponseCanonicalProductRepositoryDto>>;
    public findProductRepositoryUsingGET(id: number, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<ResponseCanonicalProductRepositoryDto>>;
    public findProductRepositoryUsingGET(id: number, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (id === null || id === undefined) {
            throw new Error('Required parameter id was null or undefined when calling findProductRepositoryUsingGET.');
        }

        let headers = this.defaultHeaders;

        // to determine the Accept header
        let httpHeaderAccepts: string[] = [
            '*/*'
        ];
        const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        if (httpHeaderAcceptSelected != undefined) {
            headers = headers.set('Accept', httpHeaderAcceptSelected);
        }

        // to determine the Content-Type header
        const consumes: string[] = [
        ];

        return this.httpClient.get<ResponseCanonicalProductRepositoryDto>(`${this.basePath}/product-repositories/${encodeURIComponent(String(id))}`,
            {
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

    /**
     * listProductRepositories
     * 
     * @param customerIds 
     * @param supplierIds 
     * @param sourceSupplierIds 
     * @param categoryIds 
     * @param repositoryIds 
     * @param productIds 
     * @param skip 
     * @param limit 
     * @param from 
     * @param to 
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public listProductRepositoriesUsingGET(customerIds?: Array<number>, supplierIds?: Array<number>, sourceSupplierIds?: Array<number>, categoryIds?: Array<number>, repositoryIds?: Array<number>, productIds?: Array<number>, skip?: number, limit?: number, from?: Date, to?: Date, observe?: 'body', reportProgress?: boolean): Observable<ResponseCanonicalListProductRepositoryDto>;
    public listProductRepositoriesUsingGET(customerIds?: Array<number>, supplierIds?: Array<number>, sourceSupplierIds?: Array<number>, categoryIds?: Array<number>, repositoryIds?: Array<number>, productIds?: Array<number>, skip?: number, limit?: number, from?: Date, to?: Date, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<ResponseCanonicalListProductRepositoryDto>>;
    public listProductRepositoriesUsingGET(customerIds?: Array<number>, supplierIds?: Array<number>, sourceSupplierIds?: Array<number>, categoryIds?: Array<number>, repositoryIds?: Array<number>, productIds?: Array<number>, skip?: number, limit?: number, from?: Date, to?: Date, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<ResponseCanonicalListProductRepositoryDto>>;
    public listProductRepositoriesUsingGET(customerIds?: Array<number>, supplierIds?: Array<number>, sourceSupplierIds?: Array<number>, categoryIds?: Array<number>, repositoryIds?: Array<number>, productIds?: Array<number>, skip?: number, limit?: number, from?: Date, to?: Date, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {











        let queryParameters = new HttpParams({encoder: new CustomHttpUrlEncodingCodec()});
        if (customerIds) {
            customerIds.forEach((element) => {
                queryParameters = queryParameters.append('customerIds', <any>element);
            })
        }
        if (supplierIds) {
            supplierIds.forEach((element) => {
                queryParameters = queryParameters.append('supplierIds', <any>element);
            })
        }
        if (sourceSupplierIds) {
            sourceSupplierIds.forEach((element) => {
                queryParameters = queryParameters.append('sourceSupplierIds', <any>element);
            })
        }
        if (categoryIds) {
            categoryIds.forEach((element) => {
                queryParameters = queryParameters.append('categoryIds', <any>element);
            })
        }
        if (repositoryIds) {
            repositoryIds.forEach((element) => {
                queryParameters = queryParameters.append('repositoryIds', <any>element);
            })
        }
        if (productIds) {
            productIds.forEach((element) => {
                queryParameters = queryParameters.append('productIds', <any>element);
            })
        }
        if (skip !== undefined && skip !== null) {
            queryParameters = queryParameters.set('skip', <any>skip);
        }
        if (limit !== undefined && limit !== null) {
            queryParameters = queryParameters.set('limit', <any>limit);
        }
        if (from !== undefined && from !== null) {
            queryParameters = queryParameters.set('from', <any>from.toISOString());
        }
        if (to !== undefined && to !== null) {
            queryParameters = queryParameters.set('to', <any>to.toISOString());
        }

        let headers = this.defaultHeaders;

        // to determine the Accept header
        let httpHeaderAccepts: string[] = [
            '*/*'
        ];
        const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        if (httpHeaderAcceptSelected != undefined) {
            headers = headers.set('Accept', httpHeaderAcceptSelected);
        }

        // to determine the Content-Type header
        const consumes: string[] = [
        ];

        return this.httpClient.get<ResponseCanonicalListProductRepositoryDto>(`${this.basePath}/product-repositories/`,
            {
                params: queryParameters,
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

    /**
     * updateProductRepository
     * 
     * @param id id
     * @param entityParam entityParam
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public updateProductRepositoryUsingPUT(id: number, entityParam: ProductRepositoryDto, observe?: 'body', reportProgress?: boolean): Observable<ResponseCanonicalProductRepositoryDto>;
    public updateProductRepositoryUsingPUT(id: number, entityParam: ProductRepositoryDto, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<ResponseCanonicalProductRepositoryDto>>;
    public updateProductRepositoryUsingPUT(id: number, entityParam: ProductRepositoryDto, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<ResponseCanonicalProductRepositoryDto>>;
    public updateProductRepositoryUsingPUT(id: number, entityParam: ProductRepositoryDto, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (id === null || id === undefined) {
            throw new Error('Required parameter id was null or undefined when calling updateProductRepositoryUsingPUT.');
        }

        if (entityParam === null || entityParam === undefined) {
            throw new Error('Required parameter entityParam was null or undefined when calling updateProductRepositoryUsingPUT.');
        }

        let headers = this.defaultHeaders;

        // to determine the Accept header
        let httpHeaderAccepts: string[] = [
            '*/*'
        ];
        const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        if (httpHeaderAcceptSelected != undefined) {
            headers = headers.set('Accept', httpHeaderAcceptSelected);
        }

        // to determine the Content-Type header
        const consumes: string[] = [
            'application/json'
        ];
        const httpContentTypeSelected: string | undefined = this.configuration.selectHeaderContentType(consumes);
        if (httpContentTypeSelected != undefined) {
            headers = headers.set('Content-Type', httpContentTypeSelected);
        }

        return this.httpClient.put<ResponseCanonicalProductRepositoryDto>(`${this.basePath}/product-repositories/${encodeURIComponent(String(id))}`,
            entityParam,
            {
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

}
