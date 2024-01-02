<template>
  <div>
    <div class="bg-white d-flex p-0">
      <div class="container-fluid">
        <div class="row h-100 align-items-center justify-content-center" style="min-height: 100vh;">
          <div class="col-12 col-sm-8 col-lg-5">
            <div class="bg-light rounded p-4 p-sm-5 my-4 mx-3">
              <div class="d-flex align-items-center justify-content-between mb-3">
                <router-link to="/" class="">
                  <h3 class="text-primary">Micro</h3>
                </router-link>
                <h3>Đăng ký</h3>
              </div>
              <div class="form-floating m-1 ">
                <input type="text" class="form-control w-100" id="floatingText" placeholder="jhondoe" v-model="username" autocomplete="off">
                <label for="floatingText">Tên đăng nhập</label>
              </div>
              <div class="text-center text-danger" v-html="messageUsername"></div>
              <div class="form-floating m-1 ">
                <input type="text" class="form-control w-100" id="floatingText" placeholder="jhondoe" v-model="password" autocomplete="off">
                <label for="floatingText">Mật khẩu</label>
              </div>
              <div class="text-center text-danger" v-html="messagePassword"></div>
              <div class="form-floating m-1">
                <input type="email" class="form-control w-100" id="floatingInput email"
                       placeholder="name@example.com" v-model="address" autocomplete="off">
                <label for="floatingInput">Địa chỉ</label>
              </div>

              <div class="text-center text-danger" v-html="messageAddress"></div>

              <div class="form-floating m-1 ">
                <input type="text" class="form-control w-100" id="floatingText" placeholder="jhondoe" v-model="email" autocomplete="off">
                <label for="floatingText">Email</label>
              </div>

              <div class="text-center text-danger fs-6 col-sm-12" v-html="messageMail"></div>

              <div class="form-floating m-1 ">
                <input type="text" class="form-control w-100" id="floatingPassword"
                       placeholder="Password" v-model="tel" autocomplete="off">
                <label for="floatingPassword">Số điện thoại</label>
              </div>

              <div class="text-center text-danger fs-6 col-sm-12" v-html="messageTel"></div>

              <div class="text-center text-danger" v-html="message"></div>
              <button type="button" class="btn btn-primary py-3 w-100 mb-2" v-on:click="register()" :disabled="isValid">Đăng ký</button>
              <RouterLink class="text-dark" to="/"><button type="button" class="py-3 w-100 mb-4 button1 ">Trở Về Trang Chủ</button></RouterLink>
              <p class="text-center mb-0">Đã có tài khoản? <RouterLink to="/login">Đăng nhập</RouterLink>
              </p>
            </div>
          </div>
        </div>
      </div>
      <!-- Sign Up End -->
    </div>
  </div>
</template>

<style src="./register.css" scoped></style>
<script src="./register.js"></script>