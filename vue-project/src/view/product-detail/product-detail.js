import axios from "axios";

export default {
    name: "product-detail",

    data(){
        return{
            product: "",
        }
    },

    mounted() {
        const productId = this.$route.params.id
        this.getProduct(productId);
    },

    methods: {
        getProduct(id){
            axios.get("https://dummyjson.com/products/" + id)
                .then(response => {
                    this.product = response.data;
                    console.log(this.product)
                })
                .catch(error => {
                    console.error('Error fetching product:', error);
                });
        }
    }
}