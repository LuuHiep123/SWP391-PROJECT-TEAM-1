import React from 'react';
import '../style/style-contact.css'
import '../style/style-home.css'
import AuthContext from "../context/AuthProvider";
import { useContext } from "react";


import { Link,useNavigate } from 'react-router-dom';

function Home() {
    const { setAuth } = useContext(AuthContext);
    const navigate = useNavigate();

    const logout = async () => {
        // if used in more components, this should be in context 
        // axios to /logout endpoint 
        setAuth({});
        navigate('/');
    }
    return (
        <>
            <header className='home'>
                <nav className="navbar navbar-expand-lg navbar-light bg-light">
                    <div className="container">
                        <Link to="/Home" className="navbar-logo" >
                            <img src="image/fpt-favicon.png" alt="Logo" width="70" />
                        </Link>
                        <p className="navbar-title">Exam Schedule Management System</p>
                        <button
                            className="navbar-toggler"
                            type="button"
                            data-toggle="collapse"
                            data-target="#navbarNav"
                            aria-controls="navbarNav"
                            aria-expanded="false"
                            aria-label="Toggle navigation"
                        ></button>
                        <div className="collapse navbar-collapse justify-content-end" id="navbarNav">
                            <ul className="navbar-nav">
                                <li className="nav-item item-menu">
                                    <Link to="/Home" className="nav-link" >
                                        Home
                                    </Link>
                                </li>
                                <li className="nav-item item-menu">
                                    <Link to="#" className="nav-link" >
                                        Exam Schedule
                                    </Link>
                                </li>
                                <li className="nav-item item-menu">
                                    <Link to="#" className="nav-link" >
                                        Contact
                                    </Link>
                                </li>
                                <li className="nav-item dropdown">
                                    <a className="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown">
                                        <img id="ProfileImage" className="rounded-circle" style={{ height: '40px', width: '40px' }} src="https://i.chungta.vn/2023/03/02/-7802-1677731962.jpg" alt="avatar-profile" />
                                    </a>
                                    <div className="dropdown-menu dropdown-menu-left">
                                        <div id="pnlProfile">
                                            <span className="dropdown-item">
                                                Name:
                                                <span id="lblName" style={{ fontWeight: 'bold' }}>FPT Nguyen</span>
                                            </span>
                                            <span className="dropdown-item">
                                                Email:
                                                <span id="pnlEmail" style={{ fontWeight: 'bold' }}>fptnguyen0@fpt.edu.vn</span>
                                            </span>
                                            <span className="dropdown-item">
                                                User's role:
                                                <span id="lblRole" style={{ fontWeight: 'bold' }}>CEO</span>
                                            </span>
                                            <span className="dropdown-item"></span>
                                            <span className="dropdown-item">
                                                <a id="lbtnSignOut" style={{ textDecoration: 'none', display: 'inline-block', width: '100%' }} onClick={logout}>
                                                    Log out
                                                </a>
                                            </span>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </header>

            <div className="container">
                <section className="contact">
                    <div className="container">
                        <h1>Welcome to Home Page</h1>

                    </div>
                </section>
            </div>

        </>
    );
}

export default Home;
