<template>
<div>
  <nav-header></nav-header>
  <router-view></router-view>
  <nav-footer></nav-footer>
</div>
</template>

<script>
import navHeader from "@/components/nav-header/nav-header.vue"
import navFooter from "@/components/nav-footer/nav-footer.vue";
export default {
  name: "management",
  components: {
    navHeader,
    navFooter
  },

}
</script>

<style src="./management.css" scoped></style>
