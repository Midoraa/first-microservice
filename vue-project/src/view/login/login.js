import axios from "axios";

import {useToast} from 'vue-toastification';
const toast = useToast();

export default {
  data() {
    return {
      username: "",
      password: "",
      messageUser: "",
      isValid: "",
      messagePass: ""
    };
  },
  mounted() {
    // if (this.isLogin()) {
    //   if (this.checkRole() == "user") {
    //     this.$router.push({ name: "Home" });
    //   } else {
    //     this.$router.push({ name: "Admin" });
    //   }
    // }
    // this.checkButton();
  },
  methods: {
    login() {
      if (this.username.length <= 2) {
        this.message = "Vui lòng nhập tên đăng nhập ít nhất 2 kí tự";
        return;
      }
      if (this.password <= 2) {
        this.message = "Vui lòng nhập mật khẩu ít nhất 2 kí tự";
        return;
      }
      axios
        .post("http://localhost:8080/api/auth/signin", {
          username: this.username,
          password: this.password,
        })
        .then((response) => {
          console.log(response);
            this.username = "";
            this.password = "";
            localStorage.setItem(
              "current-account",
              JSON.stringify({
                username: response.data.username,
                authority: response.data.roles,
              })
            );
            const token = response.data.token
            localStorage.setItem("token", token);
            axios.defaults.headers['Authorization'] = `Bearer ${token}`;

            if (response.data.roles == 'ROLE_USER'){
              this.$router.push({ name: "Home" });
            } else{
              this.$router.push({ name: "Admin" });
            }
            toast.success("Success");
        })
        .catch((error) => {
          toast.error("Wrong username or password!");
        });

    },
    isLogin() {
      return localStorage.getItem("token") != null;
    },
    checkButton() {
      if (this.username.length >= 2 && this.password.length >= 2) {
        this.isValid = false;
      } else {
        this.isValid = true;
      }
    },
  },
  watch: {
    username(newValue, oldValue) {
      if (newValue.length < 2) {
        this.messageUser = "Vui lòng nhập tên đăng nhập ít nhất 2 kí tự";
      } else {
        this.messageUser = "";
      }
      this.checkButton();
    },
    password(newValue, oldValue) {
      if (newValue.length < 2) {
        this.messagePass = "Vui lòng nhập mật khẩu ít nhất 2 kí tự";
      } else {
        this.messagePass = "";
      }
      this.checkButton();
    },
  },
};