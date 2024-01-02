<template>
    <div>
        <div class="container-fluid position-relative bg-white d-flex p-0">
            <div class="container-fluid">
                <div class="row h-100 align-items-center justify-content-center" style="min-height: 100vh;">
                    <div class="col-12 col-sm-8 col-md-7 col-lg-6 col-xl-5">
                        <div class="bg-light rounded p-4 p-sm-5 my-4 mx-3">
                            <div class="d-flex align-items-center justify-content-between mb-3">
                                <router-link to="/" class="">
                                    <h3 class="text-primary">Micro</h3>
                                </router-link>
                                <h3>Đăng nhập</h3>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="email" class="form-control" id="floatingUser" placeholder="name@example.com"
                                    v-model="username" required autocomplete="off">
                                <label for="floatingUser">Tên đăng nhập</label>
                            </div>
                            <div class="text-center text-danger" v-html="messageUser"></div>
                            <div class="form-floating mb-4">
                                <input type="password" class="form-control" id="floatingPassword" placeholder="Password"
                                    v-model="password" required autocomplete="off">
                                <label for="floatingPassword">Mật khẩu</label>
                            </div>
                            <div class="text-center text-danger" v-html="messagePass"></div>
                            <button type="button" class="btn btn-primary py-3 w-100 mb-2" @click="login()"
                                :disabled="isValid">Đăng nhập</button>
                            <RouterLink class="text-dark" to="/"><button type="button" class="py-3 w-100 mb-2 button">Trở Về
                                    Trang Chủ</button></RouterLink>

                            <p class="text-center mb-0">Chưa có tài khoản? <RouterLink to="/register">Đăng ký</RouterLink>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script src="./login.js"></script>
<style src="./login.css" scoped></style>