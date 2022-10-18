import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './Login';
import { EmployeeMenuComponent } from './EmployeeMenu';
import { PatientMenuComponent } from './PatientMenu';

const routes: Routes = [
    { path: '', component: LoginComponent },
    { path: 'EmployeeMenu', component: EmployeeMenuComponent },
    { path: 'PatientMenu', component: PatientMenuComponent },

    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

export const appRoutingModule = RouterModule.forRoot(routes);