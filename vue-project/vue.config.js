const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  publicPath : '/micro',
  devServer: {
    port: 8081,
    allowedHosts: "all",
    https: false,
    client: {
      overlay: false
    },
  },
})
