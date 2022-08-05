import * as React from 'react';
import {useEffect, useState} from 'react';
import Box from '@mui/material/Box';
import {DataGrid} from '@mui/x-data-grid';
import {default as axios} from "axios";

const columns = [
  {
    field: "id",
    headerName: "ID",
    width: 250
  },
  {
    field: "name",
    headerName: "Name",
    width: 250
  },
  {
    field: "surname",
    headerName: "Surname",
    width: 250
  },
  {
    field: "email",
    headerName: "E-Mail",
    width: 250
  },
  {
    field: "tcKimlikNo",
    headerName: "TC Kimlik No",
    width: 250
  },
  {
    field: "studentNumber",
    headerName: "Student Number",
    width: 250
  },
]


export function ListStudents() {
  const [students, setStudents] = useState([]);

  useEffect(() => {
    axios.get("/students")
      .then(student => setStudents(student.data))
  }, []);


  return (
    <Box sx={{height: 400, width: '100%'}}>
      <DataGrid
        rows={students}
        columns={columns}
        pageSize={5}
        rowsPerPageOptions={[5]}
        checkboxSelection
        disableSelectionOnClick
      />
    </Box>)
}
