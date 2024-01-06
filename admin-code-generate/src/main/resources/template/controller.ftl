package ${packageName};

@BaseResponse
@RestController
@RequestMapping
public class ${basePrefix}Controller {

    @Autowired
    private ${basePrefix}Service ${basePrefix?uncap_first}Service;

}