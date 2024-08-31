import axios from 'axios';
import { useState } from 'react';

const apiUrl = "https://homebank-q222wqfrza-uc.a.run.app";

const useApi = (basePath) => {
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const baseUrl = apiUrl + basePath;

  const request = async (method, path, data = null, config = {}) => {
    setLoading(true);
    setError(null);

    try {
      const response = await axios({
        method,
        url: `${baseUrl}${path}`,
        data,
        ...config,
      });
      return response.data;
    } catch (err) {
      setError(err);
      throw err; // Rethrow error for further handling if needed
    } finally {
      setLoading(false);
    }
  };

  const get = (path, config) => request('get', path, null, config);
  const post = (path, data, config) => request('post', path, data, config);
  const put = (path, data, config) => request('put', path, data, config);
  const del = (path, config) => request('delete', path, null, config);

  return {
    get,
    post,
    put,
    del,
    loading,
    error,
  };
};

export default useApi;
