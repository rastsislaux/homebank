import {GoogleOAuthProvider} from "@react-oauth/google";

const HBAuthProvider = ({children}) => {
  return <GoogleOAuthProvider
      clientId='795314348468-l59jk0vk2n9lvb87u1osp05n13a19b2c.apps.googleusercontent.com'
  >
    {children}
  </GoogleOAuthProvider>
};

export default HBAuthProvider;
