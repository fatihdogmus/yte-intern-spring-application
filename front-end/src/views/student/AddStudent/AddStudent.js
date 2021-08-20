import React, {useState} from "react";
import {Button, Dialog, DialogActions, DialogContent, DialogTitle, TextField} from "@material-ui/core";

export function AddStudent(props) {

  const [formState, setFormState] = useState({});

  const onFormChange = (event) => {
    const field = event.target.name;
    const value = event.target.value;
    const newState = {...formState};
    newState[field] = value;
    setFormState(newState);
  }

  return (
    <Dialog open={props.isOpen} onClose={props.onClose}>
      <DialogTitle>Add student</DialogTitle>
      <DialogContent>
        <TextField onChange={onFormChange} fullWidth name="firstName" label="First name"/>
        <TextField onChange={onFormChange} fullWidth name="lastName" label="Last name"/>
        <TextField onChange={onFormChange} fullWidth name="email" label="E-Mail"/>
        <TextField onChange={onFormChange} fullWidth name="tcKimlikNumber" label="TC Kimlik Number"/>
        <TextField onChange={onFormChange} fullWidth name="studentNumber" label="Student number"/>
      </DialogContent>
      <DialogActions>
        <Button onClick={props.onClose} color="secondary">Cancel</Button>
        <Button onClick={() => props.addStudent(formState)} color="primary">Submit</Button>
      </DialogActions>
    </Dialog>
  );
}
