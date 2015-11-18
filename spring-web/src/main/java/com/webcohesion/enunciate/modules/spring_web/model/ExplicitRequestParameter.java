package com.webcohesion.enunciate.modules.spring_web.model;


import com.webcohesion.enunciate.modules.spring_web.EnunciateSpringWebContext;

/**
 * A resource parameter with explicit values.
 * 
 * @author Ryan Heaton
 */
public class ExplicitRequestParameter extends RequestParameter {

  private final String docValue;
  private final String paramName;
  private final ResourceParameterType type;
  private final boolean multivalued;
  private final ResourceParameterConstraints constraints;

  public ExplicitRequestParameter(RequestMapping method, String docValue, String paramName, ResourceParameterType type, EnunciateSpringWebContext context) {
    this(method, docValue, paramName, type, false, new ResourceParameterConstraints.UnboundString(), context);
  }

  public ExplicitRequestParameter(RequestMapping method, String docValue, String paramName, ResourceParameterType type, boolean multivalued, ResourceParameterConstraints constraints, EnunciateSpringWebContext context) {
    super(method, context.getContext().getProcessingEnvironment());
    this.docValue = docValue;
    this.paramName = paramName;
    this.type = type;
    this.multivalued = multivalued;
    this.constraints = constraints;
  }

  public String getDocValue() {
    return docValue;
  }

  @Override
  public String getParameterName() {
    return paramName;
  }

  @Override
  public String getDefaultValue() {
    return null;
  }

  @Override
  public boolean isMatrixParam() {
    return this.type == ResourceParameterType.MATRIX;
  }

  @Override
  public boolean isQueryParam() {
    return this.type == ResourceParameterType.QUERY;
  }

  @Override
  public boolean isPathParam() {
    return this.type == ResourceParameterType.PATH;
  }

  @Override
  public boolean isCookieParam() {
    return this.type == ResourceParameterType.COOKIE;
  }

  @Override
  public boolean isHeaderParam() {
    return this.type == ResourceParameterType.HEADER;
  }

  @Override
  public boolean isFormParam() {
    return this.type == ResourceParameterType.FORM;
  }

  @Override
  public String getTypeName() {
    return this.type.toString().toLowerCase();
  }

  @Override
  public boolean isMultivalued() {
    return this.multivalued;
  }

  @Override
  protected ResourceParameterConstraints loadConstraints() {
    return this.constraints;
  }
}