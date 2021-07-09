import {Button, Dialog, DialogActions, DialogContent, DialogTitle, TextField} from "@material-ui/core";
import {ChangeEvent, useState} from "react";

interface Props {
  isOpen: boolean;
  handleClose: () => void,
  addStudent: (model: StudentModel) => void
}

export interface StudentModel {
  firstName: string;
  lastName: string;
  email: string;
  tcKimlikNumber: string;
  studentNumber: string;
}

const initialState: StudentModel = {
  firstName: "",
  lastName: "",
  email: "",
  tcKimlikNumber: "",
  studentNumber: ""
};

export function AddStudent(props: Props) {

  const [studentModel, setStudentModel] = useState<StudentModel>(initialState);

  const onFormChange = (event: ChangeEvent<HTMLInputElement>) => {
    const field = event.target.name;
    const value = event.target.value;
    //react-hook-form
    setStudentModel(updateFormState(field, value));
  }

  function updateFormState(field: string, value: string) {
    const newModelState = {...studentModel};
    switch (field) {
      case "firstName":
        newModelState.firstName = value;
        break;
      case "lastName":
        newModelState.lastName = value;
        break;
      case "email":
        newModelState.email = value;
        break;
      case "tcKimlikNumber":
        newModelState.tcKimlikNumber = value;
        break;
      case "studentNumber":
        newModelState.studentNumber = value;
        break;
    }
    return newModelState;
  }

  return (
    <Dialog
      open={props.isOpen}
      onClose={props.handleClose}>
      <DialogTitle>Add student</DialogTitle>
      <DialogContent>
        <TextField onChange={onFormChange} fullWidth name="firstName" label="First name"/>
        <TextField onChange={onFormChange} fullWidth name="lastName" label="Last name"/>
        <TextField onChange={onFormChange} fullWidth name="email" label="E-mail"/>
        <TextField onChange={onFormChange} fullWidth name="tcKimlikNumber" label="Tc Kimlik Number"/>
        <TextField onChange={onFormChange} fullWidth name="studentNumber" label="Student Number"/>
      </DialogContent>
      <DialogActions>
        <Button onClick={props.handleClose} color="secondary">
          Cancel
        </Button>
        <Button onClick={() => props.addStudent(studentModel)} color="primary">
          Submit
        </Button>
      </DialogActions>
    </Dialog>
  );

}
