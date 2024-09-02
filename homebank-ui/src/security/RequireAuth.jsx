import useAuth from "./HBAuth";
import {Navigate} from "react-router-dom";

const RequireAuth = ({hide, children}) => {
  const isAuthenticated = useAuth().isAuthenticated();

  if (isAuthenticated) {
    return <>{children}</>;
  }

  if (hide) {
    return null;
  }

  return <Navigate to="/"/>
};

export default RequireAuth;
