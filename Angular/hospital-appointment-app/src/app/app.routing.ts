import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './Login';
import { EmployeeMenuComponent } from './EmployeeMenu';
import { PatientMenuComponent } from './PatientMenu';
import { DepartmentMenuComponent } from './DepartmentMenu';
import { GenderMenuComponent } from './GenderMenu';

const routes: Routes = [
    { path: '', component: LoginComponent },
    { path: 'EmployeeMenu', component: EmployeeMenuComponent },
    { path: 'PatientMenu', component: PatientMenuComponent },
    { path: 'DepartmentMenu', component: DepartmentMenuComponent },
    { path: 'GenderMenu', component: GenderMenuComponent },

    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

export const appRoutingModule = RouterModule.forRoot(routes);
