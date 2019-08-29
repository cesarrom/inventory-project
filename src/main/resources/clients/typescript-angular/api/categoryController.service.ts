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

import { CategoryDto } from '../model/categoryDto';
import { ResponseCanonicalCategoryDto } from '../model/responseCanonicalCategoryDto';
import { ResponseCanonicalListCategoryDto } from '../model/responseCanonicalListCategoryDto';

import { BASE_PATH, COLLECTION_FORMATS }                     from '../variables';
import { Configuration }                                     from '../configuration';


@Injectable()
export class CategoryControllerService {

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
     * createCategory
     * 
     * @param entityParam entityParam
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public createCategoryUsingPOST(entityParam: CategoryDto, observe?: 'body', reportProgress?: boolean): Observable<ResponseCanonicalCategoryDto>;
    public createCategoryUsingPOST(entityParam: CategoryDto, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<ResponseCanonicalCategoryDto>>;
    public createCategoryUsingPOST(entityParam: CategoryDto, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<ResponseCanonicalCategoryDto>>;
    public createCategoryUsingPOST(entityParam: CategoryDto, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (entityParam === null || entityParam === undefined) {
            throw new Error('Required parameter entityParam was null or undefined when calling createCategoryUsingPOST.');
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

        return this.httpClient.post<ResponseCanonicalCategoryDto>(`${this.basePath}/categories/`,
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
     * findCategory
     * 
     * @param id id
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public findCategoryUsingGET(id: number, observe?: 'body', reportProgress?: boolean): Observable<ResponseCanonicalCategoryDto>;
    public findCategoryUsingGET(id: number, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<ResponseCanonicalCategoryDto>>;
    public findCategoryUsingGET(id: number, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<ResponseCanonicalCategoryDto>>;
    public findCategoryUsingGET(id: number, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (id === null || id === undefined) {
            throw new Error('Required parameter id was null or undefined when calling findCategoryUsingGET.');
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

        return this.httpClient.get<ResponseCanonicalCategoryDto>(`${this.basePath}/categories/${encodeURIComponent(String(id))}`,
            {
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

    /**
     * listCategories
     * 
     * @param skip 
     * @param limit 
     * @param from 
     * @param to 
     * @param name 
     * @param description 
     * @param parentCategoryId 
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public listCategoriesUsingGET(skip?: number, limit?: number, from?: Date, to?: Date, name?: string, description?: string, parentCategoryId?: number, observe?: 'body', reportProgress?: boolean): Observable<ResponseCanonicalListCategoryDto>;
    public listCategoriesUsingGET(skip?: number, limit?: number, from?: Date, to?: Date, name?: string, description?: string, parentCategoryId?: number, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<ResponseCanonicalListCategoryDto>>;
    public listCategoriesUsingGET(skip?: number, limit?: number, from?: Date, to?: Date, name?: string, description?: string, parentCategoryId?: number, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<ResponseCanonicalListCategoryDto>>;
    public listCategoriesUsingGET(skip?: number, limit?: number, from?: Date, to?: Date, name?: string, description?: string, parentCategoryId?: number, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {








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
        if (description !== undefined && description !== null) {
            queryParameters = queryParameters.set('description', <any>description);
        }
        if (parentCategoryId !== undefined && parentCategoryId !== null) {
            queryParameters = queryParameters.set('parentCategoryId', <any>parentCategoryId);
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

        return this.httpClient.get<ResponseCanonicalListCategoryDto>(`${this.basePath}/categories/`,
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
     * updateCategory
     * 
     * @param id id
     * @param entityParam entityParam
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public updateCategoryUsingPUT(id: number, entityParam: CategoryDto, observe?: 'body', reportProgress?: boolean): Observable<ResponseCanonicalCategoryDto>;
    public updateCategoryUsingPUT(id: number, entityParam: CategoryDto, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<ResponseCanonicalCategoryDto>>;
    public updateCategoryUsingPUT(id: number, entityParam: CategoryDto, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<ResponseCanonicalCategoryDto>>;
    public updateCategoryUsingPUT(id: number, entityParam: CategoryDto, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (id === null || id === undefined) {
            throw new Error('Required parameter id was null or undefined when calling updateCategoryUsingPUT.');
        }

        if (entityParam === null || entityParam === undefined) {
            throw new Error('Required parameter entityParam was null or undefined when calling updateCategoryUsingPUT.');
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

        return this.httpClient.put<ResponseCanonicalCategoryDto>(`${this.basePath}/categories/${encodeURIComponent(String(id))}`,
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