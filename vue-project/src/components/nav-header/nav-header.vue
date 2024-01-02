<template>
    <div>
        <div class="container-fluid p-0">
            <nav class="navbar navbar-expand-lg bg-body-tertiary">
                <div class="container-fluid">
                    <router-link to="/" class="btn-info navbar-brand">Micro</router-link>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <router-link to="/" class="btn-info nav-link">Home</router-link>
                            </li>
                            <li class="nav-item">
                                <router-link to="/product" class="btn-info nav-link">Product</router-link>
                            </li>
                            <li v-if="isAdmin">
                              <router-link to="/admin" class="btn-info nav-link">Admin</router-link>
                            </li>
                        </ul>
                        <div v-if="!isLoggedIn" class="d-flex" role="search">
                            <router-link class="btn btn-outline-success me-3" to="/register">Register</router-link>
                            <router-link class="btn btn-outline-primary" to="/login">Login</router-link>
                        </div>
                        <div v-else class="d-flex">
                          <h3 class="me-3">Xin chào, {{ username }}</h3>
                          <button class="btn btn-warning" @click="logout">Log out</button>
                        </div>
                    </div>
                </div>
            </nav>
        </div>
    </div>
</template>

<script src="./nav-header.js"></script>

<style src="./nav-header.css" scoped></style>

