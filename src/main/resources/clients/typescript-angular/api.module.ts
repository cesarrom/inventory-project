import { NgModule, ModuleWithProviders, SkipSelf, Optional } from '@angular/core';
import { Configuration } from './configuration';
import { HttpClient } from '@angular/common/http';


import { CategoryControllerService } from './api/categoryController.service';
import { CustomerControllerService } from './api/customerController.service';
import { MovementControllerService } from './api/movementController.service';
import { MovementDetailControllerService } from './api/movementDetailController.service';
import { MovementTypeControllerService } from './api/movementTypeController.service';
import { ProductControllerService } from './api/productController.service';
import { ProductRepositoryControllerService } from './api/productRepositoryController.service';
import { RepositoryControllerService } from './api/repositoryController.service';
import { RootControllerService } from './api/rootController.service';
import { SupplierControllerService } from './api/supplierController.service';

@NgModule({
  imports:      [],
  declarations: [],
  exports:      [],
  providers: [
    CategoryControllerService,
    CustomerControllerService,
    MovementControllerService,
    MovementDetailControllerService,
    MovementTypeControllerService,
    ProductControllerService,
    ProductRepositoryControllerService,
    RepositoryControllerService,
    RootControllerService,
    SupplierControllerService ]
})
export class ApiModule {
    public static forRoot(configurationFactory: () => Configuration): ModuleWithProviders {
        return {
            ngModule: ApiModule,
            providers: [ { provide: Configuration, useFactory: configurationFactory } ]
        };
    }

    constructor( @Optional() @SkipSelf() parentModule: ApiModule,
                 @Optional() http: HttpClient) {
        if (parentModule) {
            throw new Error('ApiModule is already loaded. Import in your base AppModule only.');
        }
        if (!http) {
            throw new Error('You need to import the HttpClientModule in your AppModule! \n' +
            'See also https://github.com/angular/angular/issues/20575');
        }
    }
}
