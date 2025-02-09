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
import { MovementDto } from './movementDto';
import { ProductDto } from './productDto';
import { ProductRepositoryDto } from './productRepositoryDto';


export interface MovementDetailDto { 
    createdAt?: Date;
    id?: number;
    movement?: MovementDto;
    product?: ProductDto;
    quantity?: number;
    sourceProductRepository?: ProductRepositoryDto;
    targetProductRepository?: ProductRepositoryDto;
    updatedAt?: Date;
    value?: number;
}
