import './assets/css/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import { library } from '@fortawesome/fontawesome-svg-core';
import { fas } from '@fortawesome/free-solid-svg-icons';
import Toast from "vue-toastification";
import "vue-toastification/dist/index.css";
import "vue-loading-overlay/dist/css/index.css";

import Vuetify from '@/config/Vuetify';
import 'vuetify/dist/vuetify.css';

library.add(fas);

import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min.js'
import $ from 'jquery'

window.$ = window.jQuery = $

const app = createApp(App)

app.use(router)

app.use(store)

app.use(Vuetify)

app.component('icon', FontAwesomeIcon);

app.use(Toast);

app.mount('#app');
