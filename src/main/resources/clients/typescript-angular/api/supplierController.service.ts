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

import { ResponseCanonicalListSupplierDto } from '../model/responseCanonicalListSupplierDto';
import { ResponseCanonicalSupplierDto } from '../model/responseCanonicalSupplierDto';
import { SupplierDto } from '../model/supplierDto';

import { BASE_PATH, COLLECTION_FORMATS }                     from '../variables';
import { Configuration }                                     from '../configuration';


@Injectable()
export class SupplierControllerService {

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
     * createSupplier
     * 
     * @param entityParam entityParam
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public createSupplierUsingPOST(entityParam: SupplierDto, observe?: 'body', reportProgress?: boolean): Observable<ResponseCanonicalSupplierDto>;
    public createSupplierUsingPOST(entityParam: SupplierDto, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<ResponseCanonicalSupplierDto>>;
    public createSupplierUsingPOST(entityParam: SupplierDto, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<ResponseCanonicalSupplierDto>>;
    public createSupplierUsingPOST(entityParam: SupplierDto, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (entityParam === null || entityParam === undefined) {
            throw new Error('Required parameter entityParam was null or undefined when calling createSupplierUsingPOST.');
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

        return this.httpClient.post<ResponseCanonicalSupplierDto>(`${this.basePath}/suppliers/`,
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
     * findSupplier
     * 
     * @param id id
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public findSupplierUsingGET(id: number, observe?: 'body', reportProgress?: boolean): Observable<ResponseCanonicalSupplierDto>;
    public findSupplierUsingGET(id: number, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<ResponseCanonicalSupplierDto>>;
    public findSupplierUsingGET(id: number, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<ResponseCanonicalSupplierDto>>;
    public findSupplierUsingGET(id: number, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (id === null || id === undefined) {
            throw new Error('Required parameter id was null or undefined when calling findSupplierUsingGET.');
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

        return this.httpClient.get<ResponseCanonicalSupplierDto>(`${this.basePath}/suppliers/${encodeURIComponent(String(id))}`,
            {
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

    /**
     * listSuppliers
     * 
     * @param skip 
     * @param limit 
     * @param from 
     * @param to 
     * @param name 
     * @param movementId 
     * @param productId 
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public listSuppliersUsingGET(skip?: number, limit?: number, from?: Date, to?: Date, name?: string, movementId?: number, productId?: number, observe?: 'body', reportProgress?: boolean): Observable<ResponseCanonicalListSupplierDto>;
    public listSuppliersUsingGET(skip?: number, limit?: number, from?: Date, to?: Date, name?: string, movementId?: number, productId?: number, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<ResponseCanonicalListSupplierDto>>;
    public listSuppliersUsingGET(skip?: number, limit?: number, from?: Date, to?: Date, name?: string, movementId?: number, productId?: number, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<ResponseCanonicalListSupplierDto>>;
    public listSuppliersUsingGET(skip?: number, limit?: number, from?: Date, to?: Date, name?: string, movementId?: number, productId?: number, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {








        let queryParameters = new HttpParams({encoder: new CustomHttpUrlEncodingCodec()});
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
        if (name !== undefined && name !== null) {
            queryParameters = queryParameters.set('name', <any>name);
        }
        if (movementId !== undefined && movementId !== null) {
            queryParameters = queryParameters.set('movementId', <any>movementId);
        }
        if (productId !== undefined && productId !== null) {
            queryParameters = queryParameters.set('productId', <any>productId);
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

        return this.httpClient.get<ResponseCanonicalListSupplierDto>(`${this.basePath}/suppliers/`,
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
     * updateSupplier
     * 
     * @param id id
     * @param entityParam entityParam
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public updateSupplierUsingPUT(id: number, entityParam: SupplierDto, observe?: 'body', reportProgress?: boolean): Observable<ResponseCanonicalSupplierDto>;
    public updateSupplierUsingPUT(id: number, entityParam: SupplierDto, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<ResponseCanonicalSupplierDto>>;
    public updateSupplierUsingPUT(id: number, entityParam: SupplierDto, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<ResponseCanonicalSupplierDto>>;
    public updateSupplierUsingPUT(id: number, entityParam: SupplierDto, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (id === null || id === undefined) {
            throw new Error('Required parameter id was null or undefined when calling updateSupplierUsingPUT.');
        }

        if (entityParam === null || entityParam === undefined) {
            throw new Error('Required parameter entityParam was null or undefined when calling updateSupplierUsingPUT.');
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

        return this.httpClient.put<ResponseCanonicalSupplierDto>(`${this.basePath}/suppliers/${encodeURIComponent(String(id))}`,
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