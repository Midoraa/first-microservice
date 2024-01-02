import axios from 'axios';


export default {
    name:"product",
    mounted() {
        this.getProducts();
    },
    data(){
        return {
            products: [],
        }
    },
    methods: {
        getProducts(){
            axios.get('https://dummyjson.com/products')
                .then(response => {
                    this.products = response.data.products;
                    console.log(response)
                })
                .catch(error => {
                    console.log("Loi khi getProduct", error)
                })
        }
    }
}