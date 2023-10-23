import React from 'react';
import '../style/style-login.css'
import { useGoogleLogin } from '@react-oauth/google';
import axios from 'axios';
import useAuth from '../hooks/useAuth';


import { useNavigate } from 'react-router-dom';



function Login() {

  const { setAuth } = useAuth();
  

  // Function to send user data to the backend
  const sendUserDataToBackend = async (userData) => {
    try {
      // Create a formatted user data object
      const formattedData = {
        email: userData.email,
        account_ID: userData.email.split('@')[0], // Assuming account ID is based on the email
        password: '', // You can set a default password here
        name: userData.name,
        address: '', // Set the address as needed
        gender: '', // Set the gender as needed
        dob: '', // Set the date of birth as needed
        img: userData.picture,
        // Set the role to "teacher" if the email ends with '@fe.edu.vn', otherwise set it to "student"
        rolename: userData.email.endsWith('@fe.edu.vn') ? 'teacher' : 'student',
      };

      // Send the formatted user data to the backend
      const response = await axios.post('https://your-backend-api-url', formattedData);

      // Handle the response from the backend as needed
      console.log('User data sent to the backend:', response.data);

      return response.data;
    } catch (error) {
      console.error('Error sending user data to the backend:', error);
      // Handle the error as needed, e.g., show an error message to the user
    }
  };

  // Your existing Google login code remains unchanged
  const login = useGoogleLogin({
    onSuccess: async (response) => {
      try {
        // Fetch user data from Google
        const res = await axios.get(
          "https://www.googleapis.com/oauth2/v3/userinfo", {
          headers: { Authorization: "Bearer " + response?.access_token },
        }
        );
        const userData = res.data;

        if (userData.email && (userData.email.endsWith('@fpt.edu.vn') || userData.email.endsWith('@fe.edu.vn'))) {
          // Send user data to the backend
          const backendResponse = await sendUserDataToBackend(userData);

          // Log the user data
          console.log(userData);

          // Handle user data here
          setAuth({
            user: userData
          });

          // After successful login, navigate to the Home page
          navigate('/');
        } else {
          console.log('This account is not in the organization');
          alert('This account is not in the organization');
        }
      } catch (err) {
        console.error(err);
        // Handle the error as needed, e.g., show an error message to the user
      }
    },
  });

  const navigate = useNavigate();



  return (
    <header className="login">
      <div className="login">
        <div className="thummail">
            <img src="image/background.png" alt="thummail-fptu"/>
        </div>

        <div class="themes-login">
            <div class="login_title">
                <h1>Exam Schedule Management System</h1>
            </div>
            <div class="login_form">
                <h3>Sign in</h3>
                <div class="login-account">
                    <div class="form-group">
                        <label for="Username">Username</label>
                        <input class="form-control" placeholder="Email FPT address" autofocus="" type="text" data-val="true"
                            data-val-required="The Username field is required." id="Username" name="Username" value=""/>
                    </div>
                    <div class="form-group">
                        <label for="Password">Password</label>
                        <input type="password" class="form-control"
                            placeholder="The password that the school sent to gmail" autocomplete="off" data-val="true"
                            data-val-required="The Password field is required." id="Password" name="Password"/>
                    </div>
                    <button type="submit">Login</button><br/>
                    <button type="submit">Sign up</button>
                    
                </div>
                

                <a class="btn_google" href="Home-Student.html"onClick={login}>
                    <img src="image/google-icon.png" alt="icon-google"/>Login with Google</a> <br/>

                <div class="contact">
                    <div class="btn_mail">
                        <a
                            href="mailto: sschcm@fe.edu.vn?cc=KHAOTHIHCM@fe.edu.vn&subject=Request Support From ESMS_(Sudent-fill-title-content-here)"/>
                            <img src="image/mail-forward.png" alt="mail-forward"/>
                        <a/>
                    </div>
                    <div class="btn_hotline">
                        <a href="tel: 028.73005585">
                            <img src="image/phone-filled.png" alt="hotline"/>
                        </a>
                    </div>
                    <div class="btn_web">
                        <a href="https://hcmuni.fpt.edu.vn/" rel="noopener" target="_blank">
                            <img src="image/world-www.png" alt="website"/>
                        </a>
                    </div>
                </div>

                <div class="footer">
                    <p>© Powered by FPT University</p>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </header>
  );
}

export default Login;
