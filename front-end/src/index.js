import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import {ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';

ReactDOM.render(
  <React.StrictMode>
    <ToastContainer/>
    <App/>
  </React.StrictMode>,
  document.getElementById('root')
);