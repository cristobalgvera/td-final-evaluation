import Axios from 'axios';

const axiosInstance = Axios.create({
    baseURL: `http://localhost:8081/`,
});

export default axiosInstance;