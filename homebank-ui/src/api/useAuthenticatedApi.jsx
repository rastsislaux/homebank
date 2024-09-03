import useApi from "./useApi";
import useAuth from "../security/HBAuth";
import axios from "axios";

const useAuthenticatedApi = (basePath) => {
  const { getToken } = useAuth();

  const instance = axios.create({
    headers: {
      Authorization: 'Bearer ' + getToken()
    }
  });

  const {get: baseGet, post: basePost, put: basePut, del: baseDel} = useApi(
      instance,
      basePath);

  const get = (path, config) => baseGet(path, null, config);
  const post = (path, data, config) => basePost(path, data, config);
  const put = (path, data, config) => basePut(path, data, config);
  const del = (path, config) => baseDel(path, null, config);

  return {
    get,
    post,
    put,
    del
  };
};

export default useAuthenticatedApi;
