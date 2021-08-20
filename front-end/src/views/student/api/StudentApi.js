import axios from "axios";

export class StudentApi {

  async getStudents() {
    const response = await axios.get("/students");
    return response.data;
  }

  async addStudent(student) {
    const response = await axios.post("/students", student);
    return response.data;
  }
}