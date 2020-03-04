// Getting conversion data here
this.onInstallConversionDataCanceller = appsFlyer.onInstallConversionData(
     (data) => {
      console.log("GCD")
      console.log(data)
// If it is first launch, send install data to Segment
      if (data.data.is_first_launch) {
        sendToSegment(data);
      }
     }
   );
function sendToSegment(data) {
  var campaign = {
    "source":data.data.media_source ? data.data.media_source : "",
    "name":data.data.campaign ? data.data.campaign : "",
    "ad_group":data.data.adgroup ? data.data.adgroup : ""
};
  var properties = data.data;
  properties.provider = "AppsFlyer";
  delete properties.media_source;
  delete properties.adgroup;
  delete properties.campaign;
  properties.campaign = campaign;
  console.log(properties);
  analytics.track('Install Attributed', properties);
}
