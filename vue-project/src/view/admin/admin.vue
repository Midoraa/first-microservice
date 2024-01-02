<template>
  <div class="container">

<!-- popup delelte -->
    <modal :visible="isVisibleConfirmDelete" width="600px" title="XÁC NHẬN XOÁ" :cancelButton="{
                            text: 'Trở lại',
                            onclick: closeConfirmDelete,
                        }" :okButton="{
                            text: 'Đồng ý',
                            onclick: deleteAccount,
                        }" zIndex="2000" :closable="false">
      <div>
        Bạn có chắc chắn muốn xóa {{ usernameDelete }} không ?
      </div>
    </modal>

    <!-- popup update -->
    <modal :visible="isVisibleUpdate" width="600px" title="CẬP NHẬT TÀI KHOẢN" :cancelButton="{
        text: 'Hủy',
        onclick: closeUpdateModal,
      }" :okButton="{
        text: 'Lưu',
        onclick: updateAccount,
      }" zIndex="2000" :closable="false">
      <div>
        <!-- Form để cập nhật thông tin -->
        <div class="form-group">
          <label for="updateUsername">Username:</label>
          <input v-model="updatedAccount.username" id="updateUsername" type="text">
        </div>
        <div class="form-group">
          <label for="updatePassword">Password:</label>
          <input v-model="updatedAccount.password" id="updatePassword" type="text">
        </div>
        <div class="form-group">
          <label for="updateAddress">Địa chỉ:</label>
          <input v-model="updatedAccount.address" id="updateAddress" type="text">
        </div>
        <!-- Các trường thông tin khác cần cập nhật -->
        <!-- ... -->
      </div>
    </modal>

    <h1 class="text-center my-3">Các tài khoản hiện có</h1>
    <table class="table table-bordered">
      <thead>
        <th scope="col">ID</th>
        <th scope="col">Username</th>
        <th scope="col">Địa chỉ</th>
        <th scope="col">Số điện thoại</th>
        <th scope="col">Email</th>
      </thead>
      <tr v-for="(account, index) in accounts" :key="index" v-bind:key="account.id">
        <td scope="row">{{account.id}}</td>
        <td>{{account.username}}</td>
        <td>{{account.address}}</td>
        <td>{{account.phoneNumber}}</td>
        <td>{{account.gmail}}</td>
        <td>
          <button>Update</button>
        </td>
        <td>
          <button class="btn btn-danger" @click="confirmDelete(account.id, account.username)">
            <icon icon="trash" class="svgIcon"></icon>
          </button>
        </td>
      </tr>
    </table>
  </div>
</template>

<script src="./admin.js"></script>
<style src="./admin.css" scoped></style>