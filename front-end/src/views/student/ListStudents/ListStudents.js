import {Box} from "@mui/material";
import {DataGrid} from '@mui/x-data-grid';

const columns = [
  {field: 'id', headerName: 'ID', width: 90},
  {field: 'name', headerName: 'Name', width: 150},
  {field: 'surname', headerName: 'Surname', width: 150},
  {field: 'tcKimlikNo', headerName: 'TC Kimlik No', width: 150},
  {field: 'studentNumber', headerName: 'Student Number', width: 150},
  {field: 'email', headerName: 'E-Mail', width: 150},
];


export default function ListStudents({students}) {
  return (
    <Box sx={{height: 400, width: '100%'}}>
      <DataGrid
        rows={students}
        columns={columns}
        pageSize={5}
        rowsPerPageOptions={[5]}
        checkboxSelection
        disableSelectionOnClick
        experimentalFeatures={{newEditingApi: true}}
      />
    </Box>
  );
}
