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


export interface SupplierDto { 
    address?: string;
    code?: string;
    createdAt?: Date;
    email?: string;
    id?: number;
    movements?: Array<MovementDto>;
    name?: string;
    phone?: string;
    products?: Array<ProductDto>;
    updatedAt?: Date;
}