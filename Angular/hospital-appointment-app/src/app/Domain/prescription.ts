import { Medicine } from "./medicine";

export interface Prescription {
    scriptRef: string;
    scriptIssueDate: string;
    scriptRecurrence: string;
    medicineID: Medicine;
}