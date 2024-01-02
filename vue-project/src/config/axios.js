const axios = require("axios");

const token = localStorage.getItem("token");

const instance = axios.create({
    baseURL: 'http://localhost:8080/',
    withCredentials: true,
    headers: {
        common: {
            Authorization: token !== null ? "Bearer " + token : "",
        },
    },
});

instance.interceptors.request.use(
    (config) => {
        return config;
    },
    (error) => {
        return Promise.reject(error);
    }
);