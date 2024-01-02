<template>
  <div>
    <h1 class="text-center">Chi tiết sản phẩm</h1>
    <div class="container">
      <p>Tên sản phẩm: {{ product.title }}</p>
      <p>Hãng: {{ product.brand }}</p>
      <p>Loại: {{ product.category }}</p>
      <p>Giá: {{ product.price }}</p>
      <p>Mô tả: {{ product.description }}</p>
      <p>Số lượng còn trong kho: {{ product.stock }}</p>
    </div>
  </div>
</template>

<script src="./product-detail.js"></script>
<style src="./product-detail.css" scoped></style>