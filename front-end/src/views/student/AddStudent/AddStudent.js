import * as React from "react";
import {useState} from "react";
import {Button, Dialog, DialogActions, DialogContent, DialogTitle, TextField} from "@mui/material";

export function AddStudent(props) {

  const [formState, setFormState] = useState({});

  function onFormInputChange(event) {
    const field = event.target.name;
    const value = event.target.value;
    const newState = {...formState};
    newState[field] = value;
    setFormState(newState);
  }


  return (
    <Dialog open={props.isOpen}>
      <DialogTitle>Add new student</DialogTitle>
      <DialogContent>
        <TextField onChange={onFormInputChange} name="name" label="Name" fullWidth></TextField>
        <TextField onChange={onFormInputChange} name="surname" label="Surname" fullWidth></TextField>
        <TextField onChange={onFormInputChange} name="email" label="E-Mail" fullWidth></TextField>
        <TextField onChange={onFormInputChange} name="tcKimlikNo" label="TC Kimlik No" fullWidth></TextField>
        <TextField onChange={onFormInputChange} name="studentNumber" label="Student Number" fullWidth></TextField>
      </DialogContent>
      <DialogActions>
        <Button onClick={() => props.close()} color="secondary">Cancel</Button>
        <Button onClick={() => props.addStudent(formState)}>Submit</Button>
      </DialogActions>
    </Dialog>
  );
}
