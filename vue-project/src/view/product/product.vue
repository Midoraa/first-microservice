<template>
  <h1 class="text-center my-3">Danh sách sản phẩm</h1>
  <div  class="container row m-auto" >
    <div class="product col-md-4 col-lg-3 mb-3" v-for="(product, index) in products" :key="index" v-bind:key="product.id">
      <div>
        <div class="card">
          <div class="card-body position-relative">
            <h5 class="card-title">{{product.title}}</h5>
            <h6 class="card-subtitle mb-2 text-muted">{{product.category}}</h6>
            <p class="card-text">{{product.description}}</p>
            <div class="product-below">
              <div>
                <h6 class="">{{product.price}}$</h6>
                <h6 class="">{{product.brand}}</h6>
              </div>
            </div>
            <RouterLink :to="{ name: 'ProductDetail', params: { id: product.id } }">Xem chi
              tiết
            </RouterLink>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script src="./product.js"></script>
<style src="./product.css" scoped></style>