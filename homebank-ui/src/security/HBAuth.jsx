import {jwtDecode} from "jwt-decode";

const useAuth = () => {

  const setToken = (token) => {
    localStorage.setItem('authData', token);
  };

  const getToken = () => {
    return localStorage.getItem('authData');
  };

  const getUserinfo = () => {
    const token = getToken();
    return jwtDecode(token, { header: false });
  };

  const isAuthenticated = () => !!localStorage.getItem('authData');

  const logout = () => {
    localStorage.removeItem('authData');
    window.location.href = '/';
  };

  return {
    setToken,
    getToken,
    isAuthenticated,
    getUserinfo,
    logout
  };
};

export default useAuth;
