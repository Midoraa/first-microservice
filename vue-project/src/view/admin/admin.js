import axios from "axios";
import {Modal} from "usemodal-vue3";
import {useToast} from 'vue-toastification';
const toast = useToast();

export default {
    name: "admin",
    components: {
      Modal,
    },
    data(){
        return {
            accounts: [],
            isDelete: null,
            isVisibleConfirmDelete: false,
            usernameDelete: null,
        }
    },
    mounted() {
      this.getAccounts();
    },
    methods: {
        getAccounts(){
            axios.get('http://localhost:8080/user/')
                .then(response => {
                    this.accounts = response.data;
                    console.log(response)
                })
                .catch(error => {
                    console.log("Loi khi Account", error);
                })
        },
        deleteAccount() {
            axios({
                method: 'delete',
                url: `http://localhost:8080/user/${this.idDelete}`
            })
                .then((response) => {
                    toast.success("Xóa thành công")
                    this.getAccounts();
                    this.closeConfirmDelete();
                })
                .catch((error) =>{
                    toast.error("Xóa thất bại!");
                    this.closeConfirmDelete();
                })
        },
        confirmDelete(id, username) {
            this.isVisibleConfirmDelete = true;
            this.idDelete = id;
            this.usernameDelete = username;
        },
        closeConfirmDelete() {
            this.isVisibleConfirmDelete = false;
            this.idDelete = null;
            this.usernameDelete = null;
        },
    }
}
