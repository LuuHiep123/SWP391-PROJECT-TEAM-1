import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';

import { AuthProvider } from './context/AuthProvider'
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { GoogleOAuthProvider } from '@react-oauth/google';




const root = ReactDOM.createRoot(document.getElementById('root'));

const clientId = "858164281680-uarbnjkk1l52fug0m6kppdqhm8alf044.apps.googleusercontent.com";

root.render(
  <React.StrictMode>
    <BrowserRouter>
      <GoogleOAuthProvider clientId={clientId}>
        <AuthProvider>
          <Routes>
            <Route path="/*" element={<App />} />
          </Routes>
        </AuthProvider>
      </GoogleOAuthProvider>;
    </BrowserRouter>
  </React.StrictMode>
);

