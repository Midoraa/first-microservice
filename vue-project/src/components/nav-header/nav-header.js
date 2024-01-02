export default {
    name: "nav-header",
    components: {
    },
    data() {
        return  {
            isLoggedIn: false,
            username: '',
            isAdmin: false,
        }
    },
    mounted() {
        this.checkLoginStatus();
        this.getRole();
    },
    methods: {
        logout() {
            localStorage.removeItem('current-account');
            localStorage.removeItem('token');
            this.isAdmin = false;
            this.isLoggedIn = false;
            this.username = '';
            this.$router.push({ name: 'Home' });
        },
        checkLoginStatus() {
            let account = JSON.parse(localStorage.getItem('current-account'));
            console.log(account);
            if (account) {
                this.isLoggedIn = true;
                this.username = account.username;
            } else {
                this.isLoggedIn = false;
                this.username = '';
            }
        },
        getRole() {
            let account = JSON.parse(localStorage.getItem("current-account"));
            if (account && account.authority) {
                const author = account.authority;
                this.isAdmin = author.includes('ROLE_ADMIN');
            } else {
                this.isAdmin = false;
            }
        }
    }
}