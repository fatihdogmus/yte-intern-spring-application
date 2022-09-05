import {Box} from "@mui/material";
import {DataGrid} from '@mui/x-data-grid';
import {useEffect, useState} from "react";
import axios from "axios";

const columns = [
  {field: 'id', headerName: 'ID', width: 90},
  {field: 'name', headerName: 'Name', width: 90},
  {field: 'surname', headerName: 'Surname', width: 90},
  {field: 'tcKimlikNo', headerName: 'TC Kimlik No', width: 90},
  {field: 'studentNumber', headerName: 'Student Number', width: 90},
  {field: 'email', headerName: 'E-Mail', width: 90},
];

function App() {

  const [students, setStudents] = useState([]);

  useEffect(() => {
    axios.get("/students")
      .then(response => setStudents(response.data))
  }, []);

  return (
    <div>
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
    </div>
  );
}

export default App;
