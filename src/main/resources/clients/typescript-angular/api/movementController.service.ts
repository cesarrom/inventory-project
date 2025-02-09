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

import { MovementDto } from '../model/movementDto';
import { ResponseCanonicalListMovementDto } from '../model/responseCanonicalListMovementDto';
import { ResponseCanonicalMovementDto } from '../model/responseCanonicalMovementDto';

import { BASE_PATH, COLLECTION_FORMATS }                     from '../variables';
import { Configuration }                                     from '../configuration';


@Injectable()
export class MovementControllerService {

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
     * findMovement
     * 
     * @param movementId movementId
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public findMovementUsingGET(movementId: number, observe?: 'body', reportProgress?: boolean): Observable<ResponseCanonicalMovementDto>;
    public findMovementUsingGET(movementId: number, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<ResponseCanonicalMovementDto>>;
    public findMovementUsingGET(movementId: number, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<ResponseCanonicalMovementDto>>;
    public findMovementUsingGET(movementId: number, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (movementId === null || movementId === undefined) {
            throw new Error('Required parameter movementId was null or undefined when calling findMovementUsingGET.');
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

        return this.httpClient.get<ResponseCanonicalMovementDto>(`${this.basePath}/movements/${encodeURIComponent(String(movementId))}`,
            {
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

    /**
     * generateMovement
     * 
     * @param movementInfo movementInfo
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public generateMovementUsingPOST(movementInfo: MovementDto, observe?: 'body', reportProgress?: boolean): Observable<ResponseCanonicalMovementDto>;
    public generateMovementUsingPOST(movementInfo: MovementDto, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<ResponseCanonicalMovementDto>>;
    public generateMovementUsingPOST(movementInfo: MovementDto, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<ResponseCanonicalMovementDto>>;
    public generateMovementUsingPOST(movementInfo: MovementDto, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (movementInfo === null || movementInfo === undefined) {
            throw new Error('Required parameter movementInfo was null or undefined when calling generateMovementUsingPOST.');
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

        return this.httpClient.post<ResponseCanonicalMovementDto>(`${this.basePath}/movements/`,
            movementInfo,
            {
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

    /**
     * listMovements
     * 
     * @param movementDetailIds 
     * @param productIds 
     * @param movementTypeIds 
     * @param skip 
     * @param limit 
     * @param from 
     * @param to 
     * @param sourceRepositoryId 
     * @param targetRepositoryId 
     * @param customerId 
     * @param supplierId 
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public listMovementsUsingGET(movementDetailIds?: Array<number>, productIds?: Array<number>, movementTypeIds?: Array<number>, skip?: number, limit?: number, from?: Date, to?: Date, sourceRepositoryId?: number, targetRepositoryId?: number, customerId?: number, supplierId?: number, observe?: 'body', reportProgress?: boolean): Observable<ResponseCanonicalListMovementDto>;
    public listMovementsUsingGET(movementDetailIds?: Array<number>, productIds?: Array<number>, movementTypeIds?: Array<number>, skip?: number, limit?: number, from?: Date, to?: Date, sourceRepositoryId?: number, targetRepositoryId?: number, customerId?: number, supplierId?: number, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<ResponseCanonicalListMovementDto>>;
    public listMovementsUsingGET(movementDetailIds?: Array<number>, productIds?: Array<number>, movementTypeIds?: Array<number>, skip?: number, limit?: number, from?: Date, to?: Date, sourceRepositoryId?: number, targetRepositoryId?: number, customerId?: number, supplierId?: number, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<ResponseCanonicalListMovementDto>>;
    public listMovementsUsingGET(movementDetailIds?: Array<number>, productIds?: Array<number>, movementTypeIds?: Array<number>, skip?: number, limit?: number, from?: Date, to?: Date, sourceRepositoryId?: number, targetRepositoryId?: number, customerId?: number, supplierId?: number, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {












        let queryParameters = new HttpParams({encoder: new CustomHttpUrlEncodingCodec()});
        if (movementDetailIds) {
            movementDetailIds.forEach((element) => {
                queryParameters = queryParameters.append('movementDetailIds', <any>element);
            })
        }
        if (productIds) {
            productIds.forEach((element) => {
                queryParameters = queryParameters.append('productIds', <any>element);
            })
        }
        if (movementTypeIds) {
            movementTypeIds.forEach((element) => {
                queryParameters = queryParameters.append('movementTypeIds', <any>element);
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
        if (sourceRepositoryId !== undefined && sourceRepositoryId !== null) {
            queryParameters = queryParameters.set('sourceRepositoryId', <any>sourceRepositoryId);
        }
        if (targetRepositoryId !== undefined && targetRepositoryId !== null) {
            queryParameters = queryParameters.set('targetRepositoryId', <any>targetRepositoryId);
        }
        if (customerId !== undefined && customerId !== null) {
            queryParameters = queryParameters.set('customerId', <any>customerId);
        }
        if (supplierId !== undefined && supplierId !== null) {
            queryParameters = queryParameters.set('supplierId', <any>supplierId);
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

        return this.httpClient.get<ResponseCanonicalListMovementDto>(`${this.basePath}/movements/`,
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
     * rollbackMovement
     * 
     * @param parentMovementId parentMovementId
     * @param headerInfo headerInfo
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public rollbackMovementUsingPUT(parentMovementId: number, headerInfo: MovementDto, observe?: 'body', reportProgress?: boolean): Observable<ResponseCanonicalMovementDto>;
    public rollbackMovementUsingPUT(parentMovementId: number, headerInfo: MovementDto, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<ResponseCanonicalMovementDto>>;
    public rollbackMovementUsingPUT(parentMovementId: number, headerInfo: MovementDto, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<ResponseCanonicalMovementDto>>;
    public rollbackMovementUsingPUT(parentMovementId: number, headerInfo: MovementDto, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (parentMovementId === null || parentMovementId === undefined) {
            throw new Error('Required parameter parentMovementId was null or undefined when calling rollbackMovementUsingPUT.');
        }

        if (headerInfo === null || headerInfo === undefined) {
            throw new Error('Required parameter headerInfo was null or undefined when calling rollbackMovementUsingPUT.');
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

        return this.httpClient.put<ResponseCanonicalMovementDto>(`${this.basePath}/movements/${encodeURIComponent(String(parentMovementId))}`,
            headerInfo,
            {
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

}
