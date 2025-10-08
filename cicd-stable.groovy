node('linux') {
  stage ('Poll') {
    checkout([
      $class: 'GitSCM', branches: [[name: '*/main']], extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/mcport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [
      string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/mcport.git'),
      string(name: 'PORT_DESCRIPTION', value: 'Midnight Commander is a free cross-platform orthodox file manager.'),
      string(name: 'BUILD_LINE', value: 'STABLE')
    ]
  }
}
