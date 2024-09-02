import React from 'react';
import { Card } from 'antd';
import {GoogleLogin} from "@react-oauth/google";
import useAuth from "./HBAuth";

const HBLoginPage = () => {
  const { setToken } = useAuth();

  const handleGoogleLoginSuccess = (credentialResponse) => {
    setToken(credentialResponse.credential)
    window.location.href = '/transactions';
  };

  const handleGoogleLoginError = () => {
    console.log('Login Failed');
    // Handle error here
  };

  return (
      <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', height: '100vh', background: '#f0f2f5' }}>
        <Card title={
          <img style={{backgroundColor: "transparent", padding: 16}}
               src="logo.png" width="100%"
               height="64px" alt="Homebank Logo"/>
        } style={{width: 300, textAlign: 'center'}}>
          <GoogleLogin
              text="Login with Google"
              onSuccess={handleGoogleLoginSuccess}
              onError={handleGoogleLoginError}
              style={{width: '100%'}}
          />
        </Card>
      </div>
  );
};

export default HBLoginPage;
