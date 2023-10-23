import React, { useState } from 'react';
import Login from './components/Login';
import Home from './components/Home';
import Layout from './components/Layout';
import Missing from './components/Missing';
import Unauthorized from './components/Unauthorized';
import RequireAuth from './components/RequireAuth';
import { useGoogleLogin } from '@react-oauth/google';

import { Routes, Route } from 'react-router-dom';




function App() {


  return (
    <Routes>

      <Route path="/" element={<Layout />}>
        {/* private routes */}
        <Route element={<RequireAuth />}>
          <Route path="/" element={<Home />} />
        </Route>

        {/* public routes */}
        <Route path="login" element={<Login />} />
        <Route path="uauthorized" element={<Unauthorized />} />



        {/* Catch Err if other routes */}
        <Route path="*" element={<Missing />} />
      </Route>

    </Routes>


  );
}

export default App;
