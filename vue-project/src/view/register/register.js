import axios from "axios";

import {useToast} from 'vue-toastification';

const toast = useToast();

export default {
    mounted() {
        this.checkButton();
    },
    data() {
        return {
            role: ["user"],
            username: "",
            password:"",
            email: "",
            address: "",
            tel: "",
            message: "",
            messageUsername: "",
            messagePassword:"",
            messageMail: "",
            messageAddress: "",
            messageTel: "",
            isValid: true,
        };
    },
    methods: {
        register() {
            if (this.username.length < 3) {
                this.messageUsername = "Vui lòng nhập Username ít nhất 3 ký tự!";
                return;
            }
            if (this.password.length < 3) {
                this.messageUsername = "Vui lòng nhập Password ít nhất 3 ký tự!";
                return;
            }
            if (!this.checkEmail()) {
                this.messageMail = "Vui lòng nhập đúng định dạng của email!";
                return;
            }
            if (!this.checkTel()) {
                this.messageTel = "Vui lòng nhập đúng định dạng của số điện thoại!";
                return;
            }
            if (this.address.length < 5) {
                this.messageAddress = "Vui lòng nhập địa chỉ ít nhất 5 ký tự!";
                return;
            }
            axios.post("http://localhost:8080/api/auth/signup", {
                role: this.role,
                username: this.username,
                password: this.password,
                gmail: this.email,
                address: this.address,
                phoneNumber: this.tel,
            }).then((response) => {
                    this.username = "";
                    this.password = "";
                    this.email = "";
                    this.tel = "";
                    this.address = "",
                    this.$router.push({name: "Login"});
                    toast.success("Register success");
            })
                .catch((error) => {
                    toast.error("Username has been already used!");
                });
        },
        checkEmail() {
            var regix =
                /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
            if (regix.test(this.email)) {
                return true;
            }
            return false;
        },

        checkTel() {
            var regix = /^0([3|5|7|8|9])([0-9]){8}$/;

            if (regix.test(this.tel)) {
                return true;
            }
            return false;
        },
        checkButton() {
            if (
                this.username.length >= 3 &&
                this.password.length >= 3 &&
                this.checkEmail() &&
                this.address.length >=5 &&
                this.checkTel()
            ) {
                this.isValid = false;
            } else {
                this.isValid = true;
            }
        },
    },
    watch: {
        username(newValue, oldValue) {
            if (newValue.length < 3) {
                this.messageUsername = "Vui lòng nhập tên đăng nhập ít nhất 3 ký tự!";
            } else {
                this.messageUsername = "";
            }
            this.checkButton();
        },
        password(newValue, oldValue) {
            if (newValue.length < 3) {
                this.messagePassword = "Vui lòng nhập mật khẩu ít nhất 3 ký tự!";
            } else {
                this.messagePassword = "";
            }
            this.checkButton();
        },
        address(newValue, oldValue){
            if (newValue.length < 5) {
                this.messageAddress = "Vui lòng nhập địa chỉ ít nhất 5 ký tự!";
            } else {
                this.messageAddress = "";
            }
            this.checkButton();
        },
        email(newValue, oldValue) {
            if (!this.checkEmail()) {
                this.messageMail = "Vui lòng nhập đúng định dạng của email!";
            } else {
                this.messageMail = "";
            }
            this.checkButton();
        },
        tel(newValue, oldValue) {
            if (!this.checkTel()) {
                this.messageTel = "Vui lòng nhập đúng định dạng của số điện thoại!";
            } else {
                this.messageTel = "";
            }
            this.checkButton();
        },
    },
};
