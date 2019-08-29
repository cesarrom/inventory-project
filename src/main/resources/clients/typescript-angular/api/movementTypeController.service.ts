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

import { MovementTypeDto } from '../model/movementTypeDto';
import { ResponseCanonicalListMovementTypeDto } from '../model/responseCanonicalListMovementTypeDto';
import { ResponseCanonicalMovementTypeDto } from '../model/responseCanonicalMovementTypeDto';

import { BASE_PATH, COLLECTION_FORMATS }                     from '../variables';
import { Configuration }                                     from '../configuration';


@Injectable()
export class MovementTypeControllerService {

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
     * createMovementType
     * 
     * @param entityParam entityParam
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public createMovementTypeUsingPOST(entityParam: MovementTypeDto, observe?: 'body', reportProgress?: boolean): Observable<ResponseCanonicalMovementTypeDto>;
    public createMovementTypeUsingPOST(entityParam: MovementTypeDto, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<ResponseCanonicalMovementTypeDto>>;
    public createMovementTypeUsingPOST(entityParam: MovementTypeDto, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<ResponseCanonicalMovementTypeDto>>;
    public createMovementTypeUsingPOST(entityParam: MovementTypeDto, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (entityParam === null || entityParam === undefined) {
            throw new Error('Required parameter entityParam was null or undefined when calling createMovementTypeUsingPOST.');
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

        return this.httpClient.post<ResponseCanonicalMovementTypeDto>(`${this.basePath}/movement-types/`,
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
     * findMovementType
     * 
     * @param id id
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public findMovementTypeUsingGET(id: number, observe?: 'body', reportProgress?: boolean): Observable<ResponseCanonicalMovementTypeDto>;
    public findMovementTypeUsingGET(id: number, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<ResponseCanonicalMovementTypeDto>>;
    public findMovementTypeUsingGET(id: number, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<ResponseCanonicalMovementTypeDto>>;
    public findMovementTypeUsingGET(id: number, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (id === null || id === undefined) {
            throw new Error('Required parameter id was null or undefined when calling findMovementTypeUsingGET.');
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

        return this.httpClient.get<ResponseCanonicalMovementTypeDto>(`${this.basePath}/movement-types/${encodeURIComponent(String(id))}`,
            {
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

    /**
     * listMovementTypes
     * 
     * @param skip 
     * @param limit 
     * @param from 
     * @param to 
     * @param name 
     * @param description 
     * @param sourceRepositoryId 
     * @param targetRepositoryId 
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public listMovementTypesUsingGET(skip?: number, limit?: number, from?: Date, to?: Date, name?: string, description?: string, sourceRepositoryId?: number, targetRepositoryId?: number, observe?: 'body', reportProgress?: boolean): Observable<ResponseCanonicalListMovementTypeDto>;
    public listMovementTypesUsingGET(skip?: number, limit?: number, from?: Date, to?: Date, name?: string, description?: string, sourceRepositoryId?: number, targetRepositoryId?: number, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<ResponseCanonicalListMovementTypeDto>>;
    public listMovementTypesUsingGET(skip?: number, limit?: number, from?: Date, to?: Date, name?: string, description?: string, sourceRepositoryId?: number, targetRepositoryId?: number, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<ResponseCanonicalListMovementTypeDto>>;
    public listMovementTypesUsingGET(skip?: number, limit?: number, from?: Date, to?: Date, name?: string, description?: string, sourceRepositoryId?: number, targetRepositoryId?: number, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {









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
        if (sourceRepositoryId !== undefined && sourceRepositoryId !== null) {
            queryParameters = queryParameters.set('sourceRepositoryId', <any>sourceRepositoryId);
        }
        if (targetRepositoryId !== undefined && targetRepositoryId !== null) {
            queryParameters = queryParameters.set('targetRepositoryId', <any>targetRepositoryId);
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

        return this.httpClient.get<ResponseCanonicalListMovementTypeDto>(`${this.basePath}/movement-types/`,
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
     * updateMovementType
     * 
     * @param id id
     * @param entityParam entityParam
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public updateMovementTypeUsingPUT(id: number, entityParam: MovementTypeDto, observe?: 'body', reportProgress?: boolean): Observable<ResponseCanonicalMovementTypeDto>;
    public updateMovementTypeUsingPUT(id: number, entityParam: MovementTypeDto, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<ResponseCanonicalMovementTypeDto>>;
    public updateMovementTypeUsingPUT(id: number, entityParam: MovementTypeDto, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<ResponseCanonicalMovementTypeDto>>;
    public updateMovementTypeUsingPUT(id: number, entityParam: MovementTypeDto, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (id === null || id === undefined) {
            throw new Error('Required parameter id was null or undefined when calling updateMovementTypeUsingPUT.');
        }

        if (entityParam === null || entityParam === undefined) {
            throw new Error('Required parameter entityParam was null or undefined when calling updateMovementTypeUsingPUT.');
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

        return this.httpClient.put<ResponseCanonicalMovementTypeDto>(`${this.basePath}/movement-types/${encodeURIComponent(String(id))}`,
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
