import {Button, Dialog, DialogActions, DialogContent, DialogTitle, TextField} from "@material-ui/core";

interface Props {
  isOpen: boolean;
  handleClose: () => void
}

export function AddStudent(props: Props) {

  return (
    <Dialog
      open={props.isOpen}
      onClose={props.handleClose}>
      <DialogTitle>Add student</DialogTitle>
      <DialogContent>
        <TextField fullWidth name="firstName" label="First name"/>
        <TextField fullWidth name="lastName" label="Last name"/>
        <TextField fullWidth name="email" label="E-mail"/>
        <TextField fullWidth name="tcKimlikNumber" label="Tc Kimlik Number"/>
        <TextField fullWidth name="studentNumber" label="Student Number"/>
      </DialogContent>
      <DialogActions>
        <Button onClick={props.handleClose} color="secondary">
          Cancel
        </Button>
        <Button onClick={() => console.log("hebele")} color="primary">
          Subscribe
        </Button>
      </DialogActions>
    </Dialog>
  );

}
