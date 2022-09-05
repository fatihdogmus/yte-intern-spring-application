import {Button, Dialog, DialogActions, DialogContent, DialogTitle, TextField} from "@mui/material";
import {useState} from "react";

export default function AddStudent({isOpen, close, submit}) {

  const [formState, setFormState] = useState({});

  function onFormChange(event) {

    const name = event.target.name;
    const value = event.target.value;
    const newState = {...formState};
    newState[name] = value;
    setFormState(newState);
  }

  return (
    <Dialog open={isOpen}>
      <DialogTitle>Add Student</DialogTitle>
      <DialogContent>
        <TextField onChange={onFormChange} name="name" label="Name" fullWidth></TextField>
        <TextField onChange={onFormChange} name="surname" label="Surname" fullWidth></TextField>
        <TextField onChange={onFormChange} name="email" label="E-Mail" fullWidth></TextField>
        <TextField onChange={onFormChange} name="tcKimlikNo" label="TC Kimlik No" fullWidth></TextField>
        <TextField onChange={onFormChange} name="studentNumber" label="Student Number" fullWidth></TextField>
      </DialogContent>
      <DialogActions>
        <Button onClick={() => close()} color="secondary">Cancel</Button>
        <Button onClick={() => submit(formState)}>Submit</Button>
      </DialogActions>
    </Dialog>
  );

}
